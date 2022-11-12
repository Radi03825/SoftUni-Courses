function modifier(worker) {
    if (worker.dizziness) {
        worker.levelOfHydrated += 0.1 * worker.weight * worker.experience;
        worker.dizziness = false;
    }
    return worker;
}

let worker = result({ weight: 95,
    experience: 3,
    levelOfHydrated: 0,
    dizziness: true }
);

modifier(worker);