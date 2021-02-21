import React, {useState} from 'react';
import {Container, Row, Col, Button, ListGroup, Modal} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";

const ConfirmRegister = (props) => {

    return (
        <Modal {...props} size="sm" centered>
            <Modal.Body>
                <div><input type="file"/></div>
            </Modal.Body>
            <Modal.Footer>
                <div className="m-auto">
                    <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                    <Button onClick={props.onHide}>등록</Button>
                </div>
            </Modal.Footer>
        </Modal>
    );
}

const AssetRegister = () => {
    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header/>
            <Container>
                <Row>
                    <h3>기자재 등록</h3>
                </Row>

                <Row>
                    <AdminSidebar/>
                    <Col>
                        <Button size="lg" onClick={() => setModalState(true)}>엑셀등록</Button>
                        <ListGroup horizontal className="mt-3">
                            <ListGroup.Item>대여여부</ListGroup.Item>
                            <ListGroup.Item>기자재종류</ListGroup.Item>
                            <ListGroup.Item>기자재이름</ListGroup.Item>
                            <ListGroup.Item>등록일</ListGroup.Item>
                            <ListGroup.Item>만료일</ListGroup.Item>
                            <ListGroup.Item>상태</ListGroup.Item>
                        </ListGroup>
                        <ListGroup horizontal className="mt-3">
                            <ListGroup.Item>대여가능</ListGroup.Item>
                            <ListGroup.Item>노트북</ListGroup.Item>
                            <ListGroup.Item>맥북에어2020</ListGroup.Item>
                            <ListGroup.Item>2021.02.15</ListGroup.Item>
                            <ListGroup.Item>2023.02.14</ListGroup.Item>
                            <ListGroup.Item>대여가능</ListGroup.Item>
                        </ListGroup>
                        <div>
                            <button type="submit">삭제</button>
                            <button type="submit">저장</button>
                        </div>
                    </Col>

                </Row>

                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
            </Container>
        </>
    )
}

export default AssetRegister;