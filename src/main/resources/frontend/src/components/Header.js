import React from 'react';
import styled from 'styled-components';
import {Button, Row, Col} from 'react-bootstrap';
import {Link} from 'react-router-dom'

const HomeLink = styled.div`
    font-size: 35px;
    text-color: black;
`;

const BarLink = styled.div`
    font-size: 25px;
`

const Header = () => {
    return (
        <>
            <Row className="mt-4">
                <Col md={{span: 4, offset: 2}}>
                    <HomeLink><Link to="/">컴퓨터 공학부</Link></HomeLink>
                </Col>
                <Col md={{span: 4, offset: 2}} className="text-center">
                    <Link to="/login">
                        <Button variant="light" className="mr-2">로그인</Button>                
                    </Link>
                    <Link to="/join">
                        <Button variant="light">회원가입</Button>
                    </Link>
                </Col>
            </Row>
            <Row className="justify-content-center mt-4">
                <Col md={{span: 8}} className="border text-center">
                    <div className="d-flex justify-content-around">
                        <BarLink to={"/asset"} md={{span: 3}}>
                            <Link to="/asset">기자재</Link>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Link to="/studyroom">스터디룸</Link>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Link to="/team-project">팀프로젝트</Link>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Link to="/QnA">QnA</Link>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Link to="/user/change/userinfo">마이페이지</Link>
                        </BarLink>
                    </div>
                </Col>
            </Row>
        </>
    );
}

export default Header;