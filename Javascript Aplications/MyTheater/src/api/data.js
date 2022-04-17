
import * as api from './api.js'

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function getAllTheaters() {
    return api.get('/data/theaters?sortBy=_createdOn%20desc&distinct=title')
}

export async function createTheater(theater) {
    return api.post('/data/theaters', theater)
}

export async function getTheaterById(id) {
    return api.get('/data/theaters/' + id)
}

export async function getLikesByTheaterID(theaterId) {
    return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22&distinct=_ownerId&count`)
}

export async function isTheaterLiked(theaterId, userId) {
    return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22%20and%20_ownerId%3D%22${userId}%22&count`)
}

export async function deleteTheaterById(id) {
    return api.del('/data/theaters/' + id)
}

export async function likeTheater(theaterId) {
    return api.post('/data/likes', { theaterId })
}

export async function editTheatarById(theater, id){
    return api.put('/data/theaters/'+id, theater);
}

export async function getAllTheatersByUser(userId){
    return api.get(`/data/theaters?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`)
}