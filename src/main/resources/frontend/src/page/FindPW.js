import React, { useState } from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Header from "../components/Header";
import { Link } from 'react-router-dom';

const Font1 = styled.div`
    font-size: 30px;
`;

const BodyModalFont = styled.div`
    font-size: 20px;
`;

// todo: 패스워드 틀림 모달, 학번 틀림 모달, 패스워드 변경 성공 모달

const PwModal = (props) => {
    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">비밀번호가 맞지 않습니다.</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button onClick={props.onHide}>확인</Button>
                </div>
            </Modal.Footer>
        </Modal> 
    );
}

const StModal = (props) => {
    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">학번을 찾을 수 없습니다.</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button onClick={props.onHide}>확인</Button>
                </div>
            </Modal.Footer>
        </Modal> 
    );
}

const SuccessModal = (props) => {
    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <BodyModalFont className="text-center">비밀번호 변경에 성공하였습니다.</BodyModalFont>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Link to="/">
                        <Button onClick={props.onHide}>확인</Button>
                    </Link>
                </div>
            </Modal.Footer>
        </Modal> 
    );
}

const FindPW = () => {
    const [pwModalState, setPwModalState] = useState(false);
    const [stModalState, setStModalState] = useState(false);
    const [successModalState, setSuccessModalState] = useState(false);

    const openPwModal = () => {
        setPwModalState(true);
        console.log("true");
    }

    const closePwModal = () => {
        setPwModalState(false);
    }

    return (
        <>
            <Header />
            <Container className="mt-5">
            <Row>
                <Col md={{span: 6, offset: 3}} className="mt-5">
                    <Font1>PW 찾기</Font1>
                    <div className="mt-2 border p-4">
                        <Form>
                            <Form.Group controlId="studentId">
                                <Form.Label>학번</Form.Label>
                                <Form.Control type="email" placeholder="Enter your studentId" />
                            </Form.Group>
                            <Form.Group controlId="password">
                                <Form.Label>비밀번호 변경</Form.Label>
                                <Form.Control type="password" placeholder="Enter your password" />
                            </Form.Group>
                            <Form.Group controlId="repassword">
                                <Form.Label>비밀번호 재확인</Form.Label>
                                <Form.Control type="password" placeholder="Again enter your password" />
                            </Form.Group>
                            <div className="text-center">
                                <Button onClick={() => setPwModalState(true)}>변경</Button>
                            </div>
                        </Form>
                    </div>
                </Col>
            </Row>
            <PwModal show={pwModalState} onHide={() => setPwModalState(false)} />
        </Container>
        </>
    )
}

export default FindPW;