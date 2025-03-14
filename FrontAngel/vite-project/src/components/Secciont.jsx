import { useState } from 'react';
import Modal from 'react-modal';

function Secciont() {
    const [rows, setRows] = useState([
        { id: 1, name: 'Laura', age: 30 },
        { id: 2, name: 'Jane', age: 40 },
        { id: 3, name: 'Laura', age: 30 },
        { id: 4, name: 'Jane', age: 40 },
        { id: 5, name: 'Laura', age: 30 },
        { id: 6, name: 'Jane', age: 40 },
    ]);

    const [editIndex, setEditIndex] = useState(null);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [newRow, setNewRow] = useState({ name: '', age: '' });

    const openModal = () => {
        setModalIsOpen(true);
    };

    const closeModal = () => {
        setModalIsOpen(false);
        setNewRow({ name: '', age: '' });
    };

    const addRow = () => {
        const newRowWithId = { id: rows.length + 1, ...newRow };
        setRows([...rows, newRowWithId]);
        closeModal();
    };

    const handleChange = (index, key, value) => {
        const newRows = [...rows];
        newRows[index][key] = value;
        setRows(newRows);
    };

    const handleEdit = (index) => {
        setEditIndex(index);
    };

    const handleDelete = (index) => {
        const newRows = rows.filter((row, i) => i !== index);
        setRows(newRows);
    };

    const handleSave = () => {
        setEditIndex(null);
    };

    return (
        <div>
            <button onClick={openModal}>Add New Row</button>
            <Modal className='react-modal-content' overlayClassName='react-modal-overlay' isOpen={modalIsOpen} onRequestClose={closeModal}>
                <h2>Add New Row</h2>
                <form>
                    <label>
                        Name:
                        <input
                            type="text"
                            value={newRow.name}
                            onChange={(e) => setNewRow({ ...newRow, name: e.target.value })}
                        />
                    </label>
                    <br />
                    <label>
                        Age:
                        <input
                            type="number"
                            value={newRow.age}
                            onChange={(e) => setNewRow({ ...newRow, age: e.target.value })}
                        />
                    </label>
                    <br />
                    <button type="button" onClick={addRow}>Add</button>
                    <button type="button" onClick={closeModal}>Cancel</button>
                </form>
            </Modal>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {rows.map((row, index) => (
                        <tr key={row.id}>
                            <td>{row.id}</td>
                            <td>
                                {editIndex === index ? (
                                    <input
                                        type="text"
                                        value={row.name}
                                        onChange={(e) => handleChange(index, 'name', e.target.value)}
                                    />
                                ) : (
                                    row.name
                                )}
                            </td>
                            <td>
                                {editIndex === index ? (
                                    <input
                                        type="number"
                                        value={row.age}
                                        onChange={(e) => handleChange(index, 'age', e.target.value)}
                                    />
                                ) : (
                                    row.age
                                )}
                            </td>
                            <td>
                                {editIndex === index ? (
                                    <button onClick={handleSave}>Save</button>
                                ) : (
                                    <button onClick={() => handleEdit(index)}>Edit</button>
                                )}
                                <button onClick={() => handleDelete(index)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}


export default Secciont;