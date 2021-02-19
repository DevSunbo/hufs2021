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

const dates = [
    {value: 'registerDate', label: '등록일'},
    {value: 'endDate', label: '만료일'},
    {value: 'applyDate', label: '신청일'},
    {value: 'returnDate', label: '반납일'}
]

const AssetHistory = () => {
    return (
        <>
            <Header/>
            <Container>
                <div><h2>기자재 히스토리</h2></div>


                <Row>
                    <AdminSidebar/>
                    <Col>
                        <div className="mt-2 border p-4">
                            <form action="asset">
                                <Row>
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
                                <Row>
                                    <Col>
                                    <Select
                                        defaultValue={{value: 'registerDate', label: '등록일'}}
                                        options={dates}
                                        formatGroupLabel={formatGroupLabel}
                                    />
                                    </Col>
                                    <Col>
                                    <input type="date" name="thisDate"/>
                                    </Col>
                                </Row>
                                <input type="submit" value="검색"/>
                            </form>
                        </div>
                        <Row>
                            <div>
                                <ListGroup horizontal className="mt-3">
                                    <ListGroup.Item>대여여부</ListGroup.Item>
                                    <ListGroup.Item>기자재종류</ListGroup.Item>
                                    <ListGroup.Item>기자재이름</ListGroup.Item>
                                    <ListGroup.Item>등록일</ListGroup.Item>
                                    <ListGroup.Item>만료일</ListGroup.Item>
                                    <ListGroup.Item>신청일</ListGroup.Item>
                                    <ListGroup.Item>반납일</ListGroup.Item>
                                    <ListGroup.Item>상태</ListGroup.Item>
                                    <ListGroup.Item>사용자학과</ListGroup.Item>
                                    <ListGroup.Item>사용자이름</ListGroup.Item>
                                </ListGroup>
                            </div>
                            <ListGroup horizontal className="mt-3">
                                <ListGroup.Item>대여가능</ListGroup.Item>
                                <ListGroup.Item>노트북</ListGroup.Item>
                                <ListGroup.Item>맥북에어2020</ListGroup.Item>
                                <ListGroup.Item>2021.02.15</ListGroup.Item>
                                <ListGroup.Item>2023.02.14</ListGroup.Item>
                                <ListGroup.Item>2021.02.15</ListGroup.Item>
                                <ListGroup.Item>2021.07.25</ListGroup.Item>
                                <ListGroup.Item>대여중</ListGroup.Item>
                                <ListGroup.Item>컴전</ListGroup.Item>
                                <ListGroup.Item>심선보</ListGroup.Item>
                            </ListGroup>

                        </Row>
                    </Col>
                </Row>


            </Container>

        </>
    )
}

export default AssetHistory;