import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ListGroup, Modal} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";

const ConfirmRegister = (props) => {

    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <div>시리얼번호<input type="text"/></div>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>확인</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const ConfirmSave = (props) => {

    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <div>저장하시겠습니까</div>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button onClick={props.onHide}>저장</Button>
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const AssetRent = () => {
    const [modalState, setModalState] = useState(false);
    const [modalSaveState, setModalSaveState] = useState(false);


    return (
        <>
            <Header />
            <Container>
                <div><h2>기자재 대여</h2></div>
                <Row>
                    <AdminSidebar/>
                    <Col>
                        <div className="mt-2 border p-4">
                            <Form action="">
                                <Form.Label>사용자</Form.Label>
                                <input type="text"/>
                                <button type="submit">검색</button>
                            </Form>
                        </div>
                        <Row>
                            <div>
                                <ListGroup horizontal className="mt-3">
                                    <ListGroup.Item>대여여부</ListGroup.Item>
                                    <ListGroup.Item>기자재종류</ListGroup.Item>
                                    <ListGroup.Item>기자재이름</ListGroup.Item>
                                    <ListGroup.Item>시리얼번호</ListGroup.Item>
                                    <ListGroup.Item>반납일</ListGroup.Item>
                                    <ListGroup.Item>신청자학번</ListGroup.Item>
                                    <ListGroup.Item>신청자이름</ListGroup.Item>
                                    <ListGroup.Item>상태</ListGroup.Item>
                                </ListGroup>
                            </div>
                            <div onClick={() => setModalState(true)}>
                                <ListGroup horizontal className="mt-3">
                                    <ListGroup.Item>대여가능</ListGroup.Item>
                                    <ListGroup.Item>노트북</ListGroup.Item>
                                    <ListGroup.Item>맥북에어2021</ListGroup.Item>
                                    <ListGroup.Item>시리얼번호</ListGroup.Item>
                                    <ListGroup.Item>2021.07.25</ListGroup.Item>
                                    <ListGroup.Item>201601806</ListGroup.Item>
                                    <ListGroup.Item>심선보</ListGroup.Item>
                                    <ListGroup.Item>신청중</ListGroup.Item>
                                </ListGroup>
                            </div>
                        </Row>
                        <Button size="lg" onClick={() => setModalSaveState(true)}>저장</Button>
                    </Col>
                </Row>

                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
                <ConfirmSave show={modalSaveState} onHide={() => setModalSaveState(false)} />

            </Container>
\        </>
    )
}

export default AssetRent;