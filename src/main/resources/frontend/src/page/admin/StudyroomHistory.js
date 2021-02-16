import React from 'react';
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

const StudyroomHistory = () => {
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
                                <Row>
                                    <Form.Label>사용자</Form.Label>
                                    <input type="text"/>
                                </Row>
                                <Row>
                                    <Form.Label>날짜</Form.Label>
                                    <Form.Control as="select">
                                        <option>신청일</option>
                                        <option>반납일</option>
                                    </Form.Control>
                                    <input type="date" placeholder="시작날짜"/>
                                    <input type="date" placeholder="끝날짜"/>
                                </Row>
                                <Button type="submit">검색</Button>

                            </Form>
                        </div>
                        <Row>
                            <div>
                                <ListGroup horizontal className="mt-3">
                                    <ListGroup.Item>호실</ListGroup.Item>
                                    <ListGroup.Item>번호</ListGroup.Item>
                                    <ListGroup.Item>이용일</ListGroup.Item>
                                    <ListGroup.Item>시작시간</ListGroup.Item>
                                    <ListGroup.Item>종료시간</ListGroup.Item>
                                    <ListGroup.Item>사용자학번</ListGroup.Item>
                                    <ListGroup.Item>사용자이름</ListGroup.Item>
                                </ListGroup>
                            </div>
                        </Row>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default StudyroomHistory;