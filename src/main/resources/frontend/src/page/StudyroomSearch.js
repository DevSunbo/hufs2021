import React, {useState} from 'react';
import {Container, Row, Col, Form, Button, ToggleButtonGroup, ToggleButton} from 'react-bootstrap';
import Header from "../components/Header";
import StudyroomSidebar from "../components/StudyroomSidebar";
import Select from "react-select";

const groupStyles = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
};
const groupBadgeStyles = {
    backgroundColor: '#EBECF0',
    borderRadius: '2em',
    color: '#172B4D',
    display: 'inline-block',
    fontSize: 12,
    fontWeight: 'normal',
    lineHeight: '1',
    minWidth: 1,
    padding: '0.16666666666667em 0.5em',
    textAlign: 'center',
};

const formatGroupLabel = data => (
    <div style={groupStyles}>
        <span>{data.label}</span>
        <span style={groupBadgeStyles}>{data.options.length}</span>
    </div>
);
const roomId = [{value: '306', label: '306'},
    {value: '426', label: '426'},
];


const roomNumber = [
    {value: '1', label: '1'},
    {value: '2', label: '2'},
    {value: '3', label: '3'},
    {value: '4', label: '4'}
]

const StudyroomSearch = () => {
    const [value, setValue] = useState([1, 26]);
    const handleChange = (val) => setValue(val);


    return (
        <>
            <Header/>
            <Container>
                <div><h2>스터디룸 조회</h2></div>

                <Row>
                    <StudyroomSidebar/>
                    <Col>
                        <div>
                            <Row>
                                <Col>
                                    <Form.Label>방호실</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomId}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                                <Col>
                                    <Form.Label>번호</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomNumber}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                            </Row>
                            <Row>
                                <input type="date" value="예약날짜"/>
                            </Row>
                            <Button type="submint">검색</Button>

                            <Row>

                            </Row>
                        </div>
                        <div className="border">
                            <div>
                                <ToggleButtonGroup type="checkbox" value={value} onChange={handleChange}>
                                    <ToggleButton value={1}>9:00</ToggleButton>
                                    <ToggleButton value={2}>9:30</ToggleButton>
                                    <ToggleButton value={3}>10:00</ToggleButton>
                                    <ToggleButton value={4}>10:30</ToggleButton>
                                    <ToggleButton value={5}>11:00</ToggleButton>
                                    <ToggleButton value={6}>11:30</ToggleButton>
                                </ToggleButtonGroup>

                            </div>
                            <div>
                                <ToggleButtonGroup type="checkbox" value={value} onChange={handleChange}>
                                    <ToggleButton value={7}>12:00</ToggleButton>
                                    <ToggleButton value={8}>12:30</ToggleButton>
                                    <ToggleButton value={9}>13:00</ToggleButton>
                                    <ToggleButton value={10}>13:30</ToggleButton>
                                    <ToggleButton value={11}>14:00</ToggleButton>
                                    <ToggleButton value={12}>14:30</ToggleButton>
                                </ToggleButtonGroup>
                            </div>
                            <div>
                                <ToggleButtonGroup type="checkbox" value={value} onChange={handleChange}>
                                    <ToggleButton value={13}>15:00</ToggleButton>
                                    <ToggleButton value={14}>15:30</ToggleButton>
                                    <ToggleButton value={15}>16:00</ToggleButton>
                                    <ToggleButton value={16}>16:30</ToggleButton>
                                    <ToggleButton value={17}>17:00</ToggleButton>
                                    <ToggleButton value={18}>17:30</ToggleButton>
                                </ToggleButtonGroup>
                            </div>
                            <div>
                                <ToggleButtonGroup type="checkbox" value={value} onChange={handleChange}>
                                    <ToggleButton value={19}>18:00</ToggleButton>
                                    <ToggleButton value={20}>18:30</ToggleButton>
                                    <ToggleButton value={21}>19:00</ToggleButton>
                                    <ToggleButton value={22}>19:30</ToggleButton>
                                    <ToggleButton value={23}>20:00</ToggleButton>
                                    <ToggleButton value={24}>20:30</ToggleButton>
                                </ToggleButtonGroup>
                            </div>
                            <div>
                                <ToggleButtonGroup type="checkbox" value={value} onChange={handleChange}>
                                    <ToggleButton value={25}>21:00</ToggleButton>
                                    <ToggleButton value={26}>21:30</ToggleButton>
                                </ToggleButtonGroup>
                            </div>
                        </div>

                    </Col>
                </Row>
            </Container>
        </>
    )
}

export default StudyroomSearch;