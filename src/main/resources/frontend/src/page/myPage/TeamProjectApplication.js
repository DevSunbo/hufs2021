import React from 'react';
// import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Table} from 'react-bootstrap';
import Header from "../../components/Header";
import MyPageSideBar from "../../components/MyPageSideBar";
import {Link} from 'react-router-dom';

const TeamProjectApplication = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <MyPageSideBar applyColor="text-danger" />
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
                                        <th>삭제</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {Array.from({ length: 10 }).map((_, index) => (
                                        <tr className="text-center">
                                            <td>{index}</td>
                                            <td>웹</td>
                                            <td>김정호</td>
                                            <td>
                                                <Link to="/user/team-project/apply-info">유튜브 만들기</Link>
                                            </td>
                                            <td>4</td>
                                            <td>5</td>
                                            <td>12/25</td>
                                            <td>java</td>
                                            <td>학교</td>
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

export default TeamProjectApplication;