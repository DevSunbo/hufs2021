import React from 'react';
import styled from 'styled-components';
import { Button, Row, Col } from 'react-bootstrap';
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
                    <Button variant="light" className="mr-2"><Link to="/login">로그인</Link></Button>
                    <Button variant="light"><Link to="/join">회원가입</Link></Button>
                </Col>
            </Row>
            <Row className="justify-content-center mt-4">
                <Col md={{span:8}} className="border text-center">
                    <div className="d-flex justify-content-around">
                        <BarLink md={{span: 3}}>기자재</BarLink>
                        <BarLink md={{span: 3}}>스터디룸</BarLink>
                        <BarLink md={{span: 3}}>팀프로젝트</BarLink>
                        <BarLink md={{span: 3}}>QnA</BarLink>
                        <BarLink md={{span: 3}}>마이페이지</BarLink>
                    </div>
                </Col>
            </Row>
        </>
    );
}

export default Header;