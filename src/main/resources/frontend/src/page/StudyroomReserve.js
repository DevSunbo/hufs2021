import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../components/Header";
import StudyroomSidebar from "../components/StudyroomSidebar";

const StudyroomReserve = () => {
    return (
        <>
            <Header/>
            <Container>
                <div><h2>스터디룸 조회</h2></div>
                <Row>
                    <StudyroomSidebar/>
                    <Col>

                    </Col>

                </Row>
            </Container>
        </>
    )
}

export default StudyroomReserve;