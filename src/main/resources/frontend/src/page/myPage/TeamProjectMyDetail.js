import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Table, ButtonToolbar} from 'react-bootstrap';
import Header from "../../components/Header";
import MyPageSideBar from "../../components/MyPageSideBar"
import {Link} from 'react-router-dom';

const LoginFont = styled.div`
    font-size: 30px;
`;

const Font2 = styled.div`
    font-size: 25px;
`;

const TeamProjectMyDetail = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row className="border pt-3 mb-5">
                    <MyPageSideBar registerColor="text-danger" />
                    <Col>
                        <LoginFont>상세 조회</LoginFont>
                        <div className="mt-2 border p-4">
                            <Form>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>팀장</Form.Label>
                                            <Form.Control disabled value="김정호입니다."/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>분야</Form.Label>
                                            <Form.Control disabled value="웹"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>모집인원</Form.Label>
                                            <Form.Control disabled value="4 - 5"/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>주요언어</Form.Label>
                                            <Form.Control disabled value="Java"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col>
                                    {/* todo: datepicker 고쳐야됨 */}
                                        <Form.Group>
                                            <Form.Label>마감</Form.Label>
                                            <Form.Control disabled type="date" value=""/>
                                        </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>장소</Form.Label>
                                            <Form.Control disabled value="웹"/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Col></Col>
                                    <Col>
                                        <Form.Group>
                                            <Form.Label>파일</Form.Label>
                                            <Form.Control disabled value=""/>
                                        </Form.Group>
                                    </Col>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Label>상세 설명</Form.Label>
                                    <Form.Control disabled as="textarea" row={5}/>
                                </Form.Row>
                                <Form.Row className="mt-3">
                                    <Font2>승인 인원</Font2>
                                    <Table responsive className="mt-3">
                                        <thead>
                                            <tr className="text-center">
                                                <th>학번</th>
                                                <th>이름</th>
                                                <th>전화번호</th>
                                                <th>취소</th>
                                            </tr>
                                        </thead>
                                        <tbody className="text-center">
                                            {Array.from({ length: 3}).map((_, index) => (
                                                <tr className="text-center">
                                                    <td>{index}</td>
                                                    <td>
                                                        <Link to="/user/team-project/apply-info">
                                                            김정호
                                                        </Link>
                                                    </td>
                                                    <td>01075492337</td>
                                                    <td>
                                                        <Button>취소</Button>
                                                    </td>
                                                </tr>
                                            ))}
                                        </tbody>
                                    </Table>
                                </Form.Row>
                                <Form.Row className="mt-3">
                                    <Font2>지원 인원</Font2>
                                    <Table responsive className="mt-3">
                                        <thead>
                                            <tr className="text-center">
                                                <th>학번</th>
                                                <th>이름</th>
                                                <th>전화번호</th>
                                                <th>승인</th>
                                                <th>거절</th>
                                            </tr>
                                        </thead>
                                        <tbody className="text-center">
                                            {Array.from({length: 4}).map((_, index) => (
                                                <tr className="text-center">
                                                    <td>{index}</td>
                                                    <td>
                                                        <Link to="/user/team-project/apply-info">
                                                            김정호
                                                        </Link>
                                                    </td>
                                                    <td>01075492337</td>
                                                    <td>
                                                        <Button>승인</Button>
                                                    </td>
                                                    <td>
                                                        <Button>거절</Button>
                                                    </td>
                                                </tr>
                                                ))}
                                        </tbody>
                                    </Table>
                                </Form.Row>
                                <ButtonToolbar className="justify-content-end mt-2">
                                    <Button className="mr-2">삭제</Button>
                                    <Button>수정</Button>
                                </ButtonToolbar>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default TeamProjectMyDetail;