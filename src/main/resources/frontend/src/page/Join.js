import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from '../components/Header';

const JoinFont = styled.div`
    font-size: 30px;
`;

const Join = () => {
    return (
        <>
        <Header />
        <Container className="mt-5">
            <Row>
                <Col md={{span: 6, offset: 3}} className="mt-5">
                    <JoinFont>회원가입</JoinFont>
                    <div className="mt-2 border p-4">
                        <Form>
                            <Form.Group controlId="studentId">
                                <Form.Label>학번</Form.Label>
                                <Form.Control type="email" placeholder="Enter your studentId" />
                            </Form.Group>
                            <Form.Group controlId="password">
                                <Form.Label>비밀번호</Form.Label>
                                <Form.Control type="password" placeholder="Enter your password" />
                            </Form.Group>
                            <Form.Group controlId="repassword">
                                <Form.Label>비밀번호 재확인</Form.Label>
                                <Form.Control type="password" placeholder="Enter your password Again" />
                            </Form.Group>
                            <Form.Group controlId="email">
                                <Form.Label>이메일</Form.Label>
                                <Form.Control type="email" placeholder="Enter your email" />
                            </Form.Group>
                            <Form.Row>
                                <Col>
                                    <Form.Group controlId="name">
                                        <Form.Label>이름</Form.Label>
                                        <Form.Control type="email" placeholder="Enter your name"/>
                                    </Form.Group>
                                </Col>
                                <Col>
                                    <Form.Group controlId="major">
                                        <Form.Label>학과</Form.Label>
                                        <Form.Control type="email" placeholder="Enter your major"/>
                                    </Form.Group>
                                </Col>
                            </Form.Row>
                            <Form.Row>
                                <Col>
                                    <Form.Group controlId="phoneNumber">
                                        <Form.Label>전화번호</Form.Label>
                                        <Form.Control type="email" placeholder="Enter your phone number" />
                                    </Form.Group>
                                </Col>                         
                                <Col></Col>                         
                            </Form.Row>
                            <Button type="submit" className="text-center">로그인</Button>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container>
       </>  
    );
}

export default Join;