async function lockedProfile() {
    let main = document.getElementById('main');
    main.innerHTML = '';

    let res = await fetch('http://localhost:3030/jsonstore/advanced/profiles');
    let data = await res.json();
  
    let n = 1;

    for (const d in data) {
        let profile = document.createElement('div');
        profile.className = 'profile';

        profile.innerHTML = `<img src="iconProfile2.png" class="userIcon" />
        <label>Lock</label>
        <input type="radio" name="user${n}Locked" value="lock" checked>
        <label>Unlock</label>
        <input type="radio" name="user${n}Locked" value="unlock"><br>
        <hr>
        <label>Username</label>
				<input type="text" name="user${n}Username" value="${data[d].username}" disabled readonly />
				<div id="user${n}HiddenFields">
					<hr>
					<label>Email:</label>
					<input type="email" name="user${n}Email" value="${data[d].email}" disabled readonly />
					<label>Age:</label>
					<input type="email" name="user${n}Age" value="${data[d].age}" disabled readonly />
				</div>`;


        let button = document.createElement('button');
        button.textContent = 'Show more';
        button.addEventListener('click', showInfo);

        profile.appendChild(button);

        main.appendChild(profile);

        n++;
    }

    function showInfo(ev) {
        if(ev.target.parentNode.childNodes[8].checked == true) {
            let h = ev.target.parentNode.childNodes[17];
            if(ev.target.textContent == 'Show more') {
                h.style.display = 'block';
                ev.target.textContent = 'Hide it';
            }else{
                h.style.display = 'none';
                ev.target.textContent = 'Show more';
            }
            
        }
    }
}