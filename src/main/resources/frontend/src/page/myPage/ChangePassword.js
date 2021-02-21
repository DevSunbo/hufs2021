import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../../components/Header";
import MyPageSideBar from '../../components/MyPageSideBar';

const LoginFont = styled.div`
    font-size: 30px;
`;

const ChangePassword = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <MyPageSideBar infoColor="text-danger" />
                    <Col>
                        <LoginFont>개인정보 수정</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Group>
                                    <Form.Label>현재 비밀번호</Form.Label>
                                    <Form.Control type="email" />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>변경할 비밀번호</Form.Label>
                                    <Form.Control type="email" />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>변경할 비밀번호 확인</Form.Label>
                                    <Form.Control type="email" />
                                </Form.Group>
                                <div className="text-center">
                                    <Button>저장</Button>
                                </div>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default ChangePassword;