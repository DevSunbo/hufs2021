import React from 'react';
import styled from 'styled-components';
import { Container, Row, Col, ListGroup } from 'react-bootstrap';
import Header from '../components/Header';

const Font1 = styled.div`
    font-size: 25px;
`;

const Home = () => {
    return (
        <>
            <Header />
            <Container className="mt-5">
                <Row>
                    <Col>
                        <div>
                            <div className="d-flex justify-content-between">
                                <Font1>QnA</Font1>
                                <div className="text-bottom">+more</div>
                            </div>
                            <ListGroup className="mt-3">
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                            </ListGroup>
                        </div>
                    </Col>
                    <Col>
                        <div>
                            <div className="d-flex justify-content-between">
                                <Font1>기자재 조회</Font1>
                                <div>+more</div>
                            </div>
                            <ListGroup className="mt-3">
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                            </ListGroup>
                        </div>
                        <div className="mt-3">
                            <div className="d-flex justify-content-between">
                                <Font1>팀 프로젝트</Font1>
                                <div>+more</div>
                            </div>
                            <ListGroup className="mt-3">
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                            </ListGroup>
                        </div>
                    </Col>
                </Row>
            </Container>

        </>
    )
}

export default Home;
