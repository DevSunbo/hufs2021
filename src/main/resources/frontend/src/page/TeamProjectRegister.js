import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import TeamProjectSideBar from '../components/TeamProjectSideBar';

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
                <BodyModalFont className="text-center">프로젝트를 등록하시겠습니까?</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                {/* todo: 등록 절차 */}
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>등록</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const TeamProjectRegister = () => {

    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-5 pr-5 pb-5 mb-5">
                    <TeamProjectSideBar registerColor="text-danger"/>
                    <Col>
                        <LoginFont>등록</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>팀장</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>분야</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>모집인원</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>주요언어</Form.Label>
                                            <Form.Control type="text"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    {/* todo: datepicker 수정 */}
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>마감</Form.Label>
                                            <Form.Control type="date"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>장소</Form.Label>
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
                                <Form.Row>
                                    <Form.Label>프로젝트 설명</Form.Label>
                                    <Form.Control as="textarea" row={5}/>
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
    );
}

export default TeamProjectRegister;