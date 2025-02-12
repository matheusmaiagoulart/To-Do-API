const url = "http://localhost:8080/tasks";


async function getAPI(url) {
    try {
        const response = await fetch(url, { method: "GET" });

        if (!response.ok) {
            throw new Error('Erro na requisição');
        }

        const data = await response.json();
        const tbody = document.getElementById('tasks');
        tbody.innerHTML = '';

        
        data.forEach(item => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td scope="row">${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.descricao}</td>
                <td>${item.status}</td>
                <td class="edit-btn-td">
                    <button class="edit-task-btn" data-id="${item.id}">EDIT</button>
                </td>
            `;
            tbody.appendChild(tr);
        });

        
        const editButtons = document.querySelectorAll('.edit-task-btn');
        editButtons.forEach(button => {
            button.onclick = editTask;
        });

        console.log(data); 

    } catch (error) {
        console.error("Erro ao obter dados da API:", error);
    }
}
getAPI(url);

async function addTask() {
    const titulo = prompt("Digite o título da tarefa:");
    const descricao = prompt("Digite a descrição da tarefa:");
    const status = prompt("Digite o status da tarefa dentre as opções: (ex: 'NAO_INICIADO', 'EM_ADAMENTO', 'FINALIZADO' exatamente deste jeito!):");

    
    if (titulo && descricao && status) {
        const taskData = {
            titulo: titulo,
            descricao: descricao,
            status: status
        };

        try {
            const response = await fetch('http://localhost:8080/tasks', {
                method: 'POST', // Método para adicionar a nova tarefa
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(taskData) 
            });

            if (response.ok) {
                console.log("Tarefa adicionada com sucesso!");
                getAPI('http://localhost:8080/tasks'); 
            } else {
                console.error(`Erro ao adicionar tarefa: ${response.statusText}`);
            }
        } catch (error) {
            console.error("Erro ao fazer a requisição:", error);
        }
    } else {
        alert("Por favor, preencha todos os campos!"); 
    }
}

 
document.getElementById('add-task-btn').addEventListener('click', addTask);


async function findTaskById() {
    const taskId = document.getElementById('taskIdInput').value;  

    if (!taskId) {
        alert('Por favor, insira um ID válido');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/tasks/${taskId}`, {
            method: 'GET'
        });

        if (response.ok) {
            const task = await response.json();
            console.log(task);

            // Exibe os detalhes da tarefa encontrada
            document.getElementById('task-id').textContent = task.id;
            document.getElementById('task-titulo').textContent = task.titulo;
            document.getElementById('task-descricao').textContent = task.descricao;
            document.getElementById('task-status').textContent = task.status;

            document.getElementById('taskDetails').style.display = 'block';  
        } else {
            alert(`Tarefa com ID ${taskId} não encontrada.`);

        }
    } catch (error) {
        console.error('Erro ao buscar tarefa:', error);
        alert('Erro ao buscar tarefa. Verifique o console para mais detalhes.');
    }
}

 
document.getElementById('find-task-btn').addEventListener('click', findTaskById);


async function deleteTaskById() {
    const taskId = document.getElementById('taskIdDelete').value;  

    if (!taskId) {
        alert('Por favor, insira um ID válido');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/tasks/${taskId}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert(`Tarefa com ID ${taskId} excluída com sucesso.`);
            // Opcional: você pode recarregar a lista de tarefas aqui se necessário
            getAPI(url);
        } else {
            alert(`Erro ao tentar excluir a tarefa com ID ${taskId}.`);
        }
    } catch (error) {
        console.error('Erro ao excluir a tarefa:', error);
        alert('Erro ao excluir a tarefa. Verifique o console para mais detalhes.');
    }
}

 
document.getElementById('delete-task-btn').addEventListener('click', deleteTaskById);


async function editTask() {
    const taskId = this.getAttribute('data-id');  
    console.log(taskId);
    const titulo = prompt("Digite o novo título da tarefa:");
    const descricao = prompt("Digite a nova descrição da tarefa:");
    const status = prompt("Digite o novo status da tarefa dentre as opções: (ex: 'NAO_INICIADO', 'EM_ADAMENTO', 'FINALIZADO' exatamente deste jeito!):");

    // Verifica se os valores não são nulos ou vazios
    if (titulo && descricao && status) {
        const taskData = {
        id:taskId,
            titulo: titulo,
            descricao: descricao,
            status: status
        };
        console.log("Dados da tarefa a serem atualizados:", taskData);

        try {
            const response = await fetch(`http://localhost:8080/tasks`, {
                method: 'PUT',  
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(taskData)  
            });

            if (response.ok) {
                console.log("Tarefa atualizada com sucesso!");
                getAPI(url);  
            } else {
                console.error(`Erro ao atualizar tarefa: ${response.statusText}`);
            }
        } catch (error) {
            console.error("Erro ao fazer a requisição:", error);
        }
    } else {
        alert("Por favor, preencha todos os campos!");  
    }
}
