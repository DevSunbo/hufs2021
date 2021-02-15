import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, FormGroup, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import StudyroomSidebar from "../components/StudyroomSidebar";
import AssetSidebar from "../components/AssetSidebar";

const BodyModalFont = styled.div`
    font-size: 20px;
`;


const ConfirmRegister = (props) => {

    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">예약하시겠습니까?</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>예약</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const StudyroomReserve = () => {
    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header/>
            <Container className="mt-5">
                <Row>
                    <h2>스터디룸예약</h2>
                </Row>
                <Row>
                    <StudyroomSidebar/>
                    <Col>

                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Group controlId="roomNum">
                                    <Row className="border">
                                        <Form.Label>호실</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="302호"/>
                                        </Col>
                                        <Form.Label>방번호</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="1"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="date">
                                    <Row className="border">
                                        <Form.Label>날짜</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="2021.02.15"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="time">
                                    <Row className="border">
                                        <Form.Label>시작시간</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="10:00"/>
                                        </Col>
                                        <Form.Label>종료시간</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="11:00"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <FormGroup controlId="usersSId">
                                    <Row className="border">
                                        <Form.Label>이용인원
                                            <input type="text" placeholder="학번을 입력하세요"/>
                                            <button type="submit">추가</button>
                                        </Form.Label>
                                    </Row>
                                </FormGroup>

                                <Form.Group controlId="email" >
                                    <Form.Label>주의사항</Form.Label>
                                    <Form.Control  className="border" plaintext readOnly defaultValue="주의 사항 내용"/>
                                </Form.Group>

                                <Button size="lg" onClick={() => setModalState(true)}>예약</Button>
                            </Form>
                        </div>
                    </Col>
                </Row>
                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
            </Container>
        </>
    )
}

export default StudyroomReserve;