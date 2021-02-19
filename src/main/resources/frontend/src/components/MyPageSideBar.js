import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Row, Col} from 'react-bootstrap';

const QnaFont1 = styled.div`
    font-size: 30px;
    margin-top: 10px;
    font-weight: bold;
`;

const QnaFont2 = styled.div`
    font-size: 25px;
    font-weight: normal;
    margin-top: 40px;
    vertical-align: middle;
`;

const QnaFont3 = styled.div`
    height: auto;
    padding: 0px 30px 30px 30px;
`;

const MyPageSideBar = (props) => {

    var {infoColor, assetColor, studyColor, registerColor, applyColor, qnaColor} = props;

    return (
        <>
            <Col md={{span: 3}}>
                <QnaFont3 className="text-center">
                    <QnaFont1>마이페이지</QnaFont1>
                    <QnaFont2 className="align-self-center">
                        <Link to="/user/change/userinfo">
                            <div className={infoColor}>개인정보 수정</div>
                        </Link>
                        <Link to="/user/asset/rent">
                            <div className={"mt-3 " + assetColor}>기자재 신청 현황</div>
                        </Link>
                        <Link to="/user/studyroom/info">
                            <div className={"mt-3 " + studyColor}>스터디룸 예약 현황</div>
                        </Link>
                        <Link to="/user/team-project/my-register">
                            <div className={"mt-3 " + registerColor}>등록한 팀 프로젝트</div>
                        </Link>
                        <Link to="/user/team-project/application">
                            <div className={"mt-3 " + applyColor}>신청한 팀 프로젝트</div>
                        </Link>
                        <Link to="/user/qna/info">
                            <div className={"mt-3 " + qnaColor}>나의 질문</div>
                        </Link>
                    </QnaFont2>
                </QnaFont3>
            </Col>        
        </>
    );
}

MyPageSideBar.defaultProps = {
    infoColor: "text-body",
    assetColor: "text-body",
    studyColor: "text-body",
    registerColor: "text-body",
    applyColor: "text-body",
    qnaColor: "text-body",
}

export default MyPageSideBar;