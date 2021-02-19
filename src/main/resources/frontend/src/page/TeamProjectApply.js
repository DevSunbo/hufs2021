import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import TeamProjectSideBar from "../components/TeamProjectSideBar";

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
                <BodyModalFont className="text-center">프로젝트에 지원하시겠습니까?</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                {/* todo: 지원 절차 */}
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>지원</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const TeamProjectApply = () => {

    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-5 pr-5 pb-5 mb-5">
                    <TeamProjectSideBar searchColor="text-danger"/>
                    <Col>
                        <LoginFont>지원</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>이름</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학번</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학년</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>학과</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>email</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>전화번호</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>파일</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
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

export default TeamProjectApply;