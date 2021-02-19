import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ButtonToolbar} from 'react-bootstrap';
import Header from '../components/Header';
import { Link } from 'react-router-dom';

const LoginFont = styled.div`
    font-size: 30px;
`;

const Login = () => {
   return (
       <>
        <Header />
        <Container className="mt-5">
            <Row>
                <Col md={{span: 6, offset: 3}} className="mt-5">
                    <LoginFont>로그인</LoginFont>
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
                            <ButtonToolbar className="justify-content-end">
                                <Link to="/find-pw">
                                    <Button type="button" className="mr-2">PW 찾기</Button>
                                </Link>
                                <Link to="/join">
                                    <Button type="button" className="mr-2">회원가입</Button>
                                </Link>
                                {/* todo: 로그인 성공 및 실패 작성 */}
                                <Button type="submit" className="">로그인</Button>
                            </ButtonToolbar>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container>
       </>  
   );       
}

export default Login;