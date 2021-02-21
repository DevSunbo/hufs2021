import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form} from 'react-bootstrap';
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
                    <MyPageSideBar applyColor="text-danger"/>
                    <Col>
                        <LoginFont>내 지원서 상세 조회</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이름</Form.Label>
                                            <Form.Control disabled type="text" value="김정호"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학번</Form.Label>
                                            <Form.Control disabled type="text" value="201600744"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학년</Form.Label>
                                            <Form.Control disabled type="text" value="4"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학과</Form.Label>
                                            <Form.Control disabled type="text" value="컴퓨터전자시스템공학부"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>email</Form.Label>
                                            <Form.Control disabled type="text" value="kjhkjh9753@naver.com"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>전화번호</Form.Label>
                                            <Form.Control disabled type="text" value="01075492337"/>
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
                                <Form.Row>
                                    <Form.Label>지원자 설명</Form.Label>
                                    <Form.Control as="textarea" row={5}/>
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