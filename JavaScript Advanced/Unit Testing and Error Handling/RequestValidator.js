function requestValidator(input) {

    const validMethod = ['GET', 'POST', 'DELETE', 'CONNECT'];
    const validVersion = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

    const uriRegex = /(^[\w.]+$)/;
    const msgRegex = /([<>\\&'"])/;
    if (!input.method || !validMethod.includes(input.method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    if (!input.uri || input.uri == '' || !uriRegex.test(input.uri)) {
        throw new Error('Invalid request header: Invalid URI');
    }

    if (!input.version || !validVersion.includes(input.version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    if (input.message == undefined || msgRegex.test(input.message)) {
        throw new Error('Invalid request header: Invalid Message');
    }
    return input;
}