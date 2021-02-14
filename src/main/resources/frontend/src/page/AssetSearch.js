import React, {useState} from 'react';
import Select from 'react-select';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Dropdown, FormControl, ListGroup} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";

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
//TODO: 2021.02.12 각 드롭다운에 조건을 걸어서 대여가능에 보이는것과 아닌 것 구분 & 앞에 선택하지 않으면 데이터 안보이게 하기 - sunbo
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


const AssetSearch = () => {
    return (
        <>
            <Header/>
            <Container>
                <div><h2>기자재 조회</h2></div>


                <Row>
                    <Col md={{span: 6}}>
                        <div className="border text-center">
                            <div>기자재</div>
                            <div className="align-self-center">
                                <div className="text-danger"><Link to="/asset">조회</Link></div>
                                <div className="mt-3"><Link to="/asset/apply">신청</Link></div>
                            </div>
                        </div>
                    </Col>
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
                                <input type="submit" value="검색"/>
                            </Row>
                        </form>
                    </div>
                    </Col>
                </Row>
                <Row>
                <div>
                    {/*//TODO: 2021.02.12 새로운 jsdㅔ ListGroup Data를 받는 컴포넌트 만들기 - sunbo*/}
                    <ListGroup horizontal className="mt-3">
                        <ListGroup.Item>1</ListGroup.Item>
                        <ListGroup.Item>2</ListGroup.Item>
                        <ListGroup.Item>3</ListGroup.Item>
                        <ListGroup.Item>4</ListGroup.Item>
                        <ListGroup.Item>5</ListGroup.Item>
                        <ListGroup.Item>6</ListGroup.Item>
                        <ListGroup.Item></ListGroup.Item>
                        <ListGroup.Item></ListGroup.Item>
                        <ListGroup.Item></ListGroup.Item>
                        <ListGroup.Item></ListGroup.Item>
                        <ListGroup.Item></ListGroup.Item>
                    </ListGroup>
                </div>
                </Row>
            </Container>
        </>
    );
}

export default AssetSearch;

