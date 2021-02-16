import React from 'react';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";
import AssetSidebar from "../components/AssetSidebar";
import StudyroomSidebar from "../components/StudyroomSidebar";

const StudyroomSearch = () => {
    return (
        <>
            <Header/>
            <Container>
                <div><h2>스터디룸 조회</h2></div>

                <Row>
                    <StudyroomSidebar/>
                    <Col>
                        <Row>
                            <input type="date" value="예약날짜"/>
                            <Button type="submint">검색</Button>
                        </Row>
                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default StudyroomSearch;