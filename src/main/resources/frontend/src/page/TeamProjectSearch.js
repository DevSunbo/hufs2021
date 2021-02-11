import React from 'react';
import styled from 'styled-components';
import {Route, Link} from 'react-router-dom';
import {Container, Row, Col} from 'react-bootstrap';
import Header from '../components/Header';import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../components/Header";


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
                <Row>
                    <Col md={{span: 3}}>
                        <TeamFont3 className="border text-center">
                            <TeamFont1>팀 프로젝트</TeamFont1>
                            <TeamFont2 className="align-self-center">
                                <div className="text-danger">조회</div>
                                <div className="mt-3">등록</div>
                            </TeamFont2>
                        </TeamFont3>
                    </Col>
                    <Col className="border">
                        
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default TeamSearch;