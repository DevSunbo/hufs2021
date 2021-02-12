import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";

const ApplyFont = styled.div`
    font-size: 30px;
`;

const AssetApply = () => {
    return (
        <>
            <Header/>
            <Container className="mt-5">
                <Row>
                    <ApplyFont>기자재신청</ApplyFont>
                </Row>
                <Row>
                    <Col>
                        <div className="border text-center">
                            <div>기자재</div>
                            <div className="align-self-center">
                                <div className="text-danger"><Link to="/asset">조회</Link></div>
                                <div className="mt-3"><Link to="/asset/apply">신청</Link></div>
                            </div>
                        </div>
                    </Col>
                    <Col>

                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Group controlId="caRent">
                                    <Row className="border">
                                        <Form.Label>분류</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="대여가능"/>
                                        </Col>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="종류"/>
                                        </Col>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="이름"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="restAsset">
                                    <Row className="border">
                                        <Form.Label>남은재고</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="n개"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="endDate">
                                    <Row className="border">
                                        <Form.Label>반납일</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="email" >
                                    <Form.Label>주의사항</Form.Label>
                                    <Form.Control  className="border" plaintext readOnly defaultValue="주의 사항 내용"/>
                                </Form.Group>

                                <Button type="submit" className="text-center">신청</Button>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default AssetApply;