import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ListGroup} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";
import Select from "react-select";

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

const rental = [{value: 'canRent', label: '대여가능'},
    {value: 'cannotRent', label: '대여불가능'},
];

const kind = [
    {value: 'notebook', label: '노트북'},
    {value: 'tablet', label: '태블릿'},
    {value: 'gift', label: '증점품'},
    {value: 'bipum', label: '비품'}
]

const name = [
    {value: 'leno', label: '레노버'},
    {value: 'macair', label: '맥북에어'},
]


const AssetDetail = () => {
    return (
        <>
            <Header/>
            <Container>


                <Row>
                    <AdminSidebar/>
                    <Col>

                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Group>
                                    <Row className="border"></Row>
                                    <Form.Label>시리얼번호</Form.Label>
                                    <Col>
                                        <Form.Control plaintext readOnly defaultValue="202101051"/>
                                    </Col>
                                </Form.Group>
                                <Form.Group controlId="caRent">
                                    <Row className="border">
                                        <Form.Label>분류</Form.Label>
                                        <Col>
                                            <Select
                                                defaultValue={{value: '', label: '대여여부'}}
                                                options={rental}
                                                formatGroupLabel={formatGroupLabel}
                                            />
                                        </Col>
                                        <Col>
                                            <Select
                                                defaultValue={{value: '', label: '종류'}}
                                                options={kind}
                                                formatGroupLabel={formatGroupLabel}
                                            />
                                        </Col>
                                        <Col>
                                            <Select
                                                defaultValue={{value: '', label: '이름'}}
                                                options={name}
                                                formatGroupLabel={formatGroupLabel}
                                            />
                                        </Col>

                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="restAsset">
                                    <Row className="border">
                                        <Form.Label>사용자 학과</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="컴전"/>
                                        </Col>
                                        <Form.Label>사용자 학번</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="201601806"/>
                                        </Col>
                                        <Form.Label>사용자 이름</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="심선보"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="endDate">
                                    <Row className="border">
                                        <Form.Label>상태정보</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                        </Col>
                                    </Row>
                                </Form.Group>
                                <Form.Group controlId="email" >
                                    <Row className="border">
                                        <Form.Label>신청일</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                        </Col>
                                    </Row><Row className="border">
                                    <Form.Label>반납일</Form.Label>
                                    <Col>
                                        <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                    </Col>
                                </Row>
                                </Form.Group>
                                <Form.Group controlId="email" >
                                    <Row className="border">
                                        <Form.Label>등록일</Form.Label>
                                        <Col>
                                            <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                        </Col>
                                    </Row><Row className="border">
                                    <Form.Label>만료일</Form.Label>
                                    <Col>
                                        <Form.Control plaintext readOnly defaultValue="2021/02/13"/>
                                    </Col>
                                </Row>
                                </Form.Group>

                            </Form>
                        </div>
                    </Col>

                </Row>

            </Container>
        </>
    )
}

export default AssetDetail;