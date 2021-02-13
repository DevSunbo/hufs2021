import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import {Container, Row, Col, Form, Button, Table} from 'react-bootstrap';
import Header from '../components/Header';

const TeamFont1 = styled.div`
    font-size: 30px;
    margin-top: 10px;
    font-weight: bold;
`;

const TeamFont2 = styled.div`
    font-size: 25px;
    font-weight: normal;
    margin-top: 40px;
    vertical-align: middle;
`;

const TeamFont3 = styled.div`
    height: 500px;
`;

const TeamSearch = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border mb-5 pt-3">
                    <Col md={{span: 3}}>
                        <TeamFont3 className="text-center">
                            <TeamFont1>팀 프로젝트</TeamFont1>
                            <TeamFont2 className="align-self-center">
                                <Link to="/team-project">
                                    <div className="text-danger">조회</div>
                                </Link>
                                <div className="mt-3">등록</div>
                            </TeamFont2>
                        </TeamFont3>
                    </Col>
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
                            <Table responsive className="">
                                <thead>
                                    <tr className="text-center">
                                        <th>번호</th>
                                        <th>분야</th>
                                        <th>팀장</th>
                                        <th>프로젝트 명</th>
                                        <th>최소</th>
                                        <th>최대</th>
                                        <th>마감</th>
                                        <th>주언어</th>
                                        <th>장소</th>
                                        <th>지원</th>
                                        <th>삭제</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {Array.from({ length: 12 }).map((_, index) => (
                                        <tr className="text-center">
                                            <td>{index}</td>
                                            <td>웹</td>
                                            <td>김정호</td>
                                            <td>유튜브 만들기</td>
                                            <td>4</td>
                                            <td>5</td>
                                            <td>12/25</td>
                                            <td>java</td>
                                            <td>학교</td>
                                            <td>
                                                <Button>지원</Button>
                                            </td>
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
    );
}

export default TeamSearch;