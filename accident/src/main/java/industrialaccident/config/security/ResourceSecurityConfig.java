package industrialaccident.config.security;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class ResourceSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 커스터마이징한 RequestMatcher 생성
        RequestMatcher publicUrlsWithoutAuthHeader = request ->
            new AntPathRequestMatcher("here is api url").matches(request) &&
            request.getHeader("Authorization") == null;

        http
            .authorizeRequests()
            // 커스터마이징한 RequestMatcher를 사용하여 조건부 인증 설정
            .requestMatchers(publicUrlsWithoutAuthHeader)
            .permitAll()
            // 다른 모든 요청에 대해서는 인증을 요구함
            .anyRequest()
            .authenticated()
            .and()
            .cors()
            .and()
            .csrf()
            .disable()
            .oauth2ResourceServer()
            .jwt(jwt ->
                jwt.jwtAuthenticationConverter(grantedAuthoritiesExtractor())
            );

        return http.build();
    }

    private Converter<Jwt, ? extends AbstractAuthenticationToken> grantedAuthoritiesExtractor() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(
            new GrantedAuthoritiesExtractor()
        );
        return jwtConverter;
    }

    static class GrantedAuthoritiesExtractor
        implements Converter<Jwt, Collection<GrantedAuthority>> {

        public Collection<GrantedAuthority> convert(Jwt jwt) {
            final Map<String, Collection<String>> realmAccess = jwt.getClaim(
                "realm_access"
            );
            Collection<String> roles = realmAccess.get("roles");
            for (String role : roles) System.out.println(
                "\n ===> Granted Role is :" + role.toString() + "\n"
            );

            return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
        }
    }
}
