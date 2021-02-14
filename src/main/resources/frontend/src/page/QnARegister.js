import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import QnaSideBar from '../components/QnaSideBar';

const LoginFont = styled.div`
    font-size: 30px;
`;

const BodyModalFont = styled.div`
    font-size: 20px;
`;

const ConfirmRegister = (props) => {
    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">QnA를 등록하시겠습니까?</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                {/* todo: 등록 절차 */}
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>등록</Button>
                </div>
            </Modal.Footer>
        </Modal>
    )
}

const QnARegister = () => {

    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <QnaSideBar registerColor="text-danger"/>
                    <Col>
                        <LoginFont>등록</LoginFont>
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
                                            <Form.Label>제목</Form.Label>
                                            <Form.Control disabled value="4 - 5"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>분야</Form.Label>
                                            <Form.Control disabled value="Java"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                    {/* todo: datepicker 고쳐야됨 */}
                                        <Form.Group>
                                            <Form.Label>비공개</Form.Label>
                                            <Form.Control disabled value=""/>
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
                                <div className="text-right mt-3">
                                    <Button size="lg" onClick={() => setModalState(true)}>등록</Button>
                                </div>
                            </Form>
                        </div>
                    </Col>
                </Row>
                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
            </Container>
        </>
    )
}

export default QnARegister;