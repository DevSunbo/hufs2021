import React, {useState} from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ListGroup} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";
import Select from "react-select";
import StudyroomRegister from "./StudyroomRegister";


const groupStyles = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
};
const groupBadgeStyles = {
    backgroundColor: '#EBECF0',
    borderRadius: '2em',
    color: '#172B4D',
    display: 'inline-block',
    fontSize: 12,
    fontWeight: 'normal',
    lineHeight: '1',
    minWidth: 1,
    padding: '0.16666666666667em 0.5em',
    textAlign: 'center',
};

const formatGroupLabel = data => (
    <div style={groupStyles}>
        <span>{data.label}</span>
        <span style={groupBadgeStyles}>{data.options.length}</span>
    </div>
);
const roomId = [{value: '306', label: '306'},
    {value: '426', label: '426'},
];

const roomNumber = [
    {value: '1', label: '1'},
    {value: '2', label: '2'},
    {value: '3', label: '3'},
    {value: '4', label: '4'}
]



const StudyroomManage = () => {
    const [modalState, setModalState] = useState(false);

    return (
        <>
            <Header />
            <Container>
                <Row>
                    <AdminSidebar/>
                    <Col>
                        <div className="mt-2 border p-4">
                        <Form>
                            <Row>
                                <Col>
                                    <Form.Label>방호실</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomId}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                                <Col>
                                    <Form.Label>번호</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomNumber}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                            </Row>
                            <Button type="submit">검색</Button>
                            <Button size="lg" onClick={() => setModalState(true)}>등록</Button>

                        </Form>
                        </div>
                        <Row>
                            <div>
                                <ListGroup horizontal className="mt-3">
                                    <ListGroup.Item>호실</ListGroup.Item>
                                    <ListGroup.Item>번호</ListGroup.Item>
                                    <ListGroup.Item>상태</ListGroup.Item>
                                    <ListGroup.Item>오픈시간</ListGroup.Item>
                                    <ListGroup.Item>마감시간</ListGroup.Item>
                                    <ListGroup.Item>최대인원</ListGroup.Item>
                                    <ListGroup.Item>전공</ListGroup.Item>
                                    <ListGroup.Item>현재사용자</ListGroup.Item>
                                </ListGroup>
                                <div>
                                    <button type="submit">삭제</button>
                                    <button type="submit">저장</button>
                                </div>
                            </div>
                        </Row>
                    </Col>
                </Row>
            <StudyroomRegister show={modalState} onHide={() => setModalState(false)}/>
            </Container>
        </>
    )
}

export default StudyroomManage;