import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form } from 'react-bootstrap';
import Header from "../components/Header";
import QnaSideBar from "../components/QnaSideBar";

const LoginFont = styled.div`
    font-size: 30px;
`;

const QnADetail = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-5 pr-5 pb-5 mb-5">
                    <QnaSideBar searchColor="text-danger" />
                    <Col>
                        <LoginFont>상세 조회</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>제목</Form.Label>
                                            <Form.Control disabled value="기자재 관련해서..." />
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>분야</Form.Label>
                                            <Form.Control disabled value="기자재" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>작성자</Form.Label>
                                            <Form.Control disabled value="기자재 관련해서..." />
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>비공개</Form.Label>
                                            <Form.Control disabled value="기자재" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>해결 여부</Form.Label>
                                            <Form.Control disabled value="기자재 관련해서..." />
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>파일</Form.Label>
                                            <Form.Control disabled value="기자재" />
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Label>상세 설명</Form.Label>
                                    <Form.Control disabled as="textarea" row={5} />
                                </Form.Row>
                                <Form.Row>
                                    <Form.Label>답변</Form.Label>
                                    <Form.Control disabled as="textarea" row={5} />
                                </Form.Row>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default QnADetail;