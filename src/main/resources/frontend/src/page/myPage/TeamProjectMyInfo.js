import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form} from 'react-bootstrap';
import Header from "../../components/Header";
import MyPageSideBar from "../../components/MyPageSideBar";

const LoginFont = styled.div`
    font-size: 30px;
`;

const TeamProjectMyInfo = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <MyPageSideBar registerColor="text-danger" />
                    <Col>
                        <LoginFont>지원자 상세 조회</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이름</Form.Label>
                                            <Form.Control disabled value="김정호입니다."/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학번</Form.Label>
                                            <Form.Control disabled value="웹"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>전화번호</Form.Label>
                                            <Form.Control disabled value="4 - 5"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>email</Form.Label>
                                            <Form.Control disabled value="Java"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                    {/* todo: datepicker 고쳐야됨 */}
                                        <Form.Group>
                                            <Form.Label>학년</Form.Label>
                                            <Form.Control disabled type="date" value=""/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>파일</Form.Label>
                                            <Form.Control disabled value="웹"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Label>상세 설명</Form.Label>
                                    <Form.Control disabled as="textarea" row={5}/>
                                </Form.Row>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default TeamProjectMyInfo;