import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../../components/Header";
import MyPageSideBar from "../../components/MyPageSideBar";

const LoginFont = styled.div`
    font-size: 30px;
`;

const TeamProjectMyApplyInfo = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-5 pr-5 pb-5 mb-5">
                    <MyPageSideBar searchColor="text-danger"/>
                    <Col>
                        <LoginFont>지원</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이름</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학번</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학년</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학과</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>email</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>전화번호</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>파일</Form.Label>
                                            <Form.Control disabled type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default TeamProjectMyApplyInfo;