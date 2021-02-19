import React, {useState} from 'react';
import Select from 'react-select';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Dropdown, FormControl, ListGroup} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";

const StudyroomSidebar = () => {
    return (
        <Col md={{span: 3}}>
            <div className="border text-center">
                <div>스터디룸</div>
                <div className="align-self-center">
                    <div className="text-danger"><Link to="/studyroom">스터디룸조회</Link></div>
                    <div className="mt-3"><Link to="/studyroom/reserve">스터디룸예약</Link></div>
                </div>
            </div>
        </Col>
    );
}

export default StudyroomSidebar;