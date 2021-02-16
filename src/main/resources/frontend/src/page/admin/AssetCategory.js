import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, ListGroup} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminSidebar from "../../components/AdminSidebar";

const AssetCategory = () => {
    return (
        <>
            <Header />
            <Container>
                <Row>
                    <AdminSidebar/>
                    <Col>
                        <Button type="submit" >삭제</Button>
                        <ListGroup horizontal className="mt-3">
                            <ListGroup.Item>대여여부</ListGroup.Item>
                            <ListGroup.Item>기자재종류</ListGroup.Item>
                            <ListGroup.Item>기자재이름</ListGroup.Item>
                            <ListGroup.Item>등록일</ListGroup.Item>
                            <ListGroup.Item>등록자</ListGroup.Item>
                        </ListGroup>
                        <Button type="submit" >저장</Button>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default AssetCategory;