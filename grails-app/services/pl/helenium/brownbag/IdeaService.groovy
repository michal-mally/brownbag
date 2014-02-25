package pl.helenium.brownbag

import org.bson.types.ObjectId

class IdeaService {

    List<Idea> getAll() {
        Idea.list().sort { - it.votes.size() }
    }

    void create(Idea idea) {
        idea.save(validate: true, flush: true)
    }

    void vote(String ideaId, String userId) {
        assert userId : "userId mustn't be null!"

        def idea = Idea.get(new ObjectId(ideaId))
        assert idea : "idea mustn't be null"

        if (!idea.votes.contains(userId)) {
            idea.addToVotes(userId)
            idea.save()
        }
    }

}
