import React from 'react';
import styled from 'styled-components';
import { Button, Container, Row, Col } from 'react-bootstrap';
// import {Link} from 'react-router-dom'

const HomeLink = styled.div`
    font-size: 30px;
`;

function header() {
    return (
        <Container>
            <Row className="mt-4">
                <Col md={{span: 4, offset: 2}}>
                    <HomeLink>컴퓨터 공학부</HomeLink>
                </Col>
                <Col md={{span: 4, offset: 2}}>
                    <Button variant="success" className="mr-2">로그인</Button>
                    <Button variant="danger">회원가입</Button>
                </Col>
            </Row>
            <Row className="justify-content-center mt-3">
                <Col md={{span:8}} className="border text-center">
                    <Button className="m-2">기자재</Button>
                    <Button className="m-2">스터디룸</Button>
                    <Button className="m-2">팀프로젝트</Button>
                    <Button className="m-2">QnA</Button>
                    <Button className="m-2">마이페이지</Button>
                </Col>
            </Row>
        </Container>
    );
}

export default header;