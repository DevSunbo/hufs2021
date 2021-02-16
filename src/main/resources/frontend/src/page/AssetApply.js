import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";
import AssetSidebar from "../components/AssetSidebar";

const ApplyFont = styled.div`
    font-size: 30px;
`;
const BodyModalFont = styled.div`
    font-size: 20px;
`;


const ConfirmRegister = (props) => {
    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">신청하시겠습니까?</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>신청</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const AssetApply = () => {
    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header/>
            <Container className="mt-5">
                <Row>
                    <ApplyFont>기자재신청</ApplyFont>
                </Row>
                <Row>
                    <AssetSidebar/>
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

                                <Button size="lg" onClick={() => setModalState(true)}>신청</Button>
                            </Form>
                        </div>
                    </Col>
                </Row>
                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
            </Container>
        </>
    )
}

export default AssetApply;