import React from 'react';
// import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Table} from 'react-bootstrap';
import Header from "../components/Header";
import QnaSideBar from "../components/QnaSideBar";
import {Link} from "react-router-dom";

const QnASearch = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <QnaSideBar searchColor="text-danger"/>
                    <Col className="border">
                        <Form className="mt-3">
                            <Form.Row>
                                <Form.Group as={Col} md="3">
                                    <Form.Control as="select" defaultValue="전체">
                                        <option>전체</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group as={Col} md="6">
                                    <Form.Control placeholder="제목 검색" />
                                </Form.Group>
                                <Form.Group as={Col} md="3">
                                    <Button>검색</Button>
                                </Form.Group>
                            </Form.Row>
                        </Form>
                        <Row>
                            <Table responsive>
                                <thead>
                                    <tr className="text-center">
                                        <th>번호</th>
                                        <th>비공개</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>분야</th>
                                        <th>마감일</th>
                                        <th>해결여부</th>
                                        <th>삭제</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {Array.from({ length: 10}).map((_, index) => (
                                        <tr className="text-center">
                                            <td>{index}</td>
                                            <td>아이콘</td>
                                            <td>
                                                <Link to="/qna/detail">
                                                    유튜브
                                                </Link>
                                            </td>
                                            <td>김정호</td>
                                            <td>기자재</td>
                                            <td>12/25</td>
                                            <td>해결</td>
                                            <td>
                                                <Button>삭제</Button>
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </Table>
                        </Row>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default QnASearch;