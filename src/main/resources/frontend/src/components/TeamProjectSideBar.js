import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Row, Col} from 'react-bootstrap';

const TeamFont1 = styled.div`
    font-size: 30px;
    margin-top: 10px;
    font-weight: bold;
`;

const TeamFont2 = styled.div`
    font-size: 25px;
    font-weight: normal;
    margin-top: 40px;
    vertical-align: middle;
`;

const TeamFont3 = styled.div`
    height: auto;
    padding: 0px 30px 30px 30px;
`;

const TeamProjectSideBar = ({searchColor, registerColor}) => {
    return (
        <>
            <Col md={{span: 3}}>
                <TeamFont3 className="text-center">
                    <TeamFont1>팀 프로젝트</TeamFont1>
                    <TeamFont2 className="align-self-center">
                        <Link to="/team-project">
                            <div className={searchColor}>조회 및 지원</div>
                        </Link>
                        <Link to="/team-project/register">
                            <div className={"mt-3 " + registerColor}>등록</div>
                        </Link>
                    </TeamFont2>
                </TeamFont3>
            </Col>        
        </>
    );
}

TeamProjectSideBar.defaultProps = {
    searchColor: "text-body",
    registerColor: "text-body"
}

export default TeamProjectSideBar;