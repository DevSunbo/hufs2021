import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ButtonToolbar} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import Header from "../../components/Header";
import MyPageSideBar from '../../components/MyPageSideBar';

const LoginFont = styled.div`
    font-size: 30px;
`;

const UserInfoModify = () => {
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
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이름</Form.Label>
                                            <Form.Control disabled value="김정호" />
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학번</Form.Label>
                                            <Form.Control disabled value="201600744" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학년</Form.Label>
                                            <Form.Control disabled value="4" />
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학과</Form.Label>
                                            <Form.Control disabled value="컴퓨터전자시스템공학부" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>연락처</Form.Label>
                                            <Form.Control value="01075492337"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이메일</Form.Label>
                                            <Form.Control value="kjhkjh9753@naver.com" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <ButtonToolbar className="justify-content-end">
                                    <Link to="/user/change/password">
                                        <Button className="mr-2">비밀번호 변경</Button>
                                    </Link>
                                    <Button>수정</Button>
                                </ButtonToolbar>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default UserInfoModify;