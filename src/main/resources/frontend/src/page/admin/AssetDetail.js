import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ListGroup} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";

const AssetDetail = () => {
    return (
        <>
            <Header/>
            <Container>


                <Row>
                    <AdminSidebar/>
                    <Col>
                        <Row>
                            <h3>기자재정보</h3>
                        </Row>
                        <Row></Row>
                        <div>
                            <button type="submit">삭제</button>
                            <button type="submit">저장</button>
                        </div>
                    </Col>

                </Row>

                <ConfirmRegister show={modalState} onHide={() => setModalState(false)} />
            </Container>
        </>
    )
}

export default AssetDetail;