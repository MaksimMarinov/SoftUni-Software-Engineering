class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`;
        } else if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`;
        }
        else {
            return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`;
        }

    }


    like(username) {
        if (this._likes.includes(username)) {
            throw new Error("You can't like the same story twice!");
        }

        if (username === this.creator) {
            throw new Error("You can't like your own story!");
        }

        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (!this._likes.includes(username)) {
            throw new Error("You can't dislike this story!");
        }

        this._likes = this._likes.filter(user => user !== username);

        return `${username} disliked ${this.title}`;
    }

    comment(username, content, id){
        let currentComment = this._comments.find(comment=>comment.id ===id);
        if(id===undefined||currentComment===undefined){
            currentComment= {username, content, id: this._comments.length+1, replies: []};
            this._comments.push(currentComment);
            return `${username} commented on ${this.title}`;
        }
        let repliedId = Number(id + '.'+(currentComment.replies.length+1));
        currentComment.replies.push({id:repliedId, username, content});
        return "You replied successfully";


    }
    toString(sortingType) {
        let result = `Title: ${this.title}\nCreator: ${this.creator}\nLikes: ${this._likes.length}\nComments:\n`;
        if(this._comments.length>0){
            switch (sortingType) {
                case 'asc':
                    sortAsc(this._comments)
                        .forEach(comment=>{
                            result+=`-- ${comment.id}. ${comment.username}: ${comment.content}\n`;
                            if(comment.replies.length>0){
                                sortAsc(comment.replies).forEach(reply=>{
                                    result+=`--- ${reply.id}. ${reply.username}: ${reply.content}\n`
                                })
                            }
                        })
                    break;
                case 'desc':
                    sortDesc(this._comments)
                        .forEach(comment=>{
                            result+=`-- ${comment.id}. ${comment.username}: ${comment.content}\n`;
                            if(comment.replies.length>0){
                                sortDesc(comment.replies).forEach(reply=>{
                                    result+=`--- ${reply.id}. ${reply.username}: ${reply.content}\n`
                                })
                            }
                        })
                    break;
                case 'username':

                    sortUserName(this._comments).forEach(comment=>{
                        result+=`-- ${comment.id}. ${comment.username}: ${comment.content}\n`;
                        if(comment.replies.length>0){
                            sortUserName( comment.replies).forEach(reply=>{
                                result+=`--- ${reply.id}. ${reply.username}: ${reply.content}\n`
                            })
                        }
                    })
                    break;
            }
        }

        return result.trim();

        function sortAsc(array ){
            array.sort((a,b)=>a.id-b.id);
            return array;
        }
        function sortDesc(array ){
            array.sort((a,b)=>b.id-a.id);
            return array;
        }
        function sortUserName(array){
            array.sort((a,b)=>a.username.localeCompare(b.username))
            return array;
        }
    }



}