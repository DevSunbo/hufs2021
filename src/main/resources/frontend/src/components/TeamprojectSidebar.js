import React, {useState} from 'react';
import Select from 'react-select';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Dropdown, FormControl, ListGroup} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";

const TeamprojectSidebar = () => {
    return (
        <Col md={{span: 3}}>
            <div className="border text-center">
                <div>팀프로젝트</div>
                <div className="align-self-center">
                    <div className="text-danger"><Link to="/team-project">팀프로젝트조회</Link></div>
                    <div className="mt-3"><Link to="/team-project/apply">팀프로젝트신청</Link></div>
                    <div className="mt-3"><Link to="/team-project/register">팀프로젝트등록</Link></div>
                </div>
            </div>
        </Col>
    );
}

export default TeamprojectSidebar;