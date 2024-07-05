
import React, { useEffect, useState } from 'react'

import { Link, useLocation, useNavigate } from 'react-router-dom'

import * as EgovNet from 'api/egovFetch'
import { NOTICE_BBS_ID } from 'config'
import CODE from 'constants/code'
import URL from 'constants/url'
import axios from 'axios';

import EgovAttachFile from 'components/EgovAttachFile'
import { default as EgovLeftNav } from 'components/leftmenu/EgovLeftNavInform'
import bbsFormVaildator from 'utils/bbsFormVaildator'

function EgovNoticeEdit(props) {
    console.group("EgovNoticeEdit");
    console.log("EgovNoticeEdit [props] : ", props);
    props = {mode: CODE.MODE_CREATE};

    const navigate = useNavigate();
    const location = useLocation();
    console.log("EgovNoticeEdit [location] : ", location);

    const bbsId = location.state?.bbsId || NOTICE_BBS_ID;
    const nttId = location.state?.nttId || "";

    const [modeInfo, setModeInfo] = useState({ mode: props.mode });
    const [masterBoard, setMasterBoard] = useState({});
    const [boardDetail, setBoardDetail] = useState({ nttSj: '', nttCn: '' });
    const [boardAttachFiles, setBoardAttachFiles] = useState();

    const initMode = () => {
        switch (props.mode) {
            case CODE.MODE_CREATE:
                setModeInfo({
                    ...modeInfo,
                    modeTitle: "등록",
                    method: "POST",
                    editURL: '/assessments'
                });
                break;
            
			default:
                navigate({pathname: URL.ERROR}, {state: {msg : ""}});
        }
    }

    const updateBoard = () => {
        const formData = new FormData();
        for (let key in boardDetail) {
            formData.append(key, boardDetail[key]);
        }

        const entity = {
            id: boardDetail.id,
            accidentId: boardDetail.accidentId,
            businessCode: boardDetail.businessCode,
            employeeId: boardDetail.employeeId,
            assessorId: boardDetail.assessorId,
            hospitalCode: boardDetail.hospitalCode,
            doctorNote: boardDetail.doctorNote,
            results: boardDetail.results,
            date: boardDetail.date,
            comments: boardDetail.comments
        };

        axios.post('/assessments', entity)
        .then(response => {
            const resp = response.data;
            if (response.data.id) {
                navigate('/assessment/assessments');
            } else {
                navigate({pathname: URL.ERROR}, {state: {msg: ""}});
            }
        })
        .catch(error => {
            console.error('Request failed:', error);
            navigate({pathname: URL.ERROR}, {state: {msg: error.message}});
        });
    };

	const Location = React.memo(function Location(masterBoard) {
        return (
            <div className="location">
                <ul>
                    <li><Link to={URL.MAIN} className="home">Home</Link></li>
                    <li><Link to="/assessment/assessments">Assessment</Link></li>
                    <li>{masterBoard && masterBoard.bbsNm}</li>
                </ul>
            </div>
        )
    });

    useEffect(function () {
        initMode();
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    console.groupEnd("EgovNoticeEdit");

    return (
        <div className="container">
            <div className="c_wrap">
                {/* <!-- Location --> */}
                <Location />
                {/* <!--// Location --> */}

                <div className="layout">
                    {/* <!-- Navigation --> */}
                    <EgovLeftNav></EgovLeftNav>
                    {/* <!--// Navigation --> */}

                    <div className="contents NOTICE_LIST" id="contents">
                        {/* <!-- 본문 --> */}

                        <div className="top_tit">
                            <h1 className="tit_1">Assessment</h1>
                        </div>
                        
                        <h2 className="tit_2">{masterBoard && masterBoard.bbsNm} {modeInfo.modeTitle}</h2>

                        <div className="board_view2">
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">Id</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="id" name="id" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, id: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">AccidentId</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="accidentId" name="accidentId" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, accidentId: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">BusinessCode</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="businessCode" name="businessCode" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, businessCode: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">EmployeeId</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="employeeId" name="employeeId" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, employeeId: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">AssessorId</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="assessorId" name="assessorId" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, assessorId: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">HospitalCode</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="hospitalCode" name="hospitalCode" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, hospitalCode: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">DoctorNote</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="doctorNote" name="doctorNote" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, doctorNote: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">Results</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="results" name="results" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, results: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">Date</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="date" name="date" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, date: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            <dl>
                                <dt>
                                    <label htmlFor="nttSj">Comments</label>
                                </dt>
                                <dd>
                                    <input className="f_input2 w_full" id="comments" name="comments" type="text"
                                        onChange={e => setBoardDetail({ ...boardDetail, comments: e.target.value })}
                                        maxLength="60" />
                                </dd>
                            </dl>
                            {/* <!-- 버튼영역 --> */}
                            <div className="board_btn_area">
                                <div className="left_col btn1">
                                    <button className="btn btn_skyblue_h46 w_100"
                                        onClick={() => updateBoard()}>저장</button>
                                </div>

                                <div className="right_col btn1">
                                    <Link to="/assessment/assessments" className="btn btn_blue_h46 w_100">목록</Link>
                                </div>
                            </div>
                            {/* <!--// 버튼영역 --> */}
                        </div>

                        {/* <!--// 본문 --> */}
                    </div>

                </div>
            </div>
        </div>
    );
}

export default EgovNoticeEdit;