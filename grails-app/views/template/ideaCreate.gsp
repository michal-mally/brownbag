<div class="panel-heading">
    <h3 class="panel-title">Dodawanie nowego pomysłu</h3>
</div>

<form name="idea_form" novalidate ng-submit="create(idea)">
    <div class="panel-body">

        <div class="input-group">
            <span class="input-group-addon"></span>
            <input type="text" name="title" class="form-control" placeholder="Tytuł" ng-model="idea.title"
                   ng-minlength="6" maxlength="255" required>
        </div>
        <small class="error"
               ng-show="idea_form.title.$error.minlength">Tytuł musi mieć długość przynajmniej 6 znaków</small>

        <div class="input-group">
            <span class="input-group-addon"></span>
            <input type="url" name="location" class="form-control" placeholder="Link" ng-model="idea.location"
                   required>
        </div>
        <small class="error"
               ng-show="idea_form.location.$error.url">Link musi być poprawnym adresem internetowym</small>

        <div class="input-group">
            <span class="input-group-addon"></span>
            <input type="number" name="duration" class="form-control" placeholder="Czas trwania"
                   ng-model="idea.duration"
                   min="1" max="180" required>
            <span class="input-group-addon">min</span>
        </div>
        <small class="error"
               ng-show="idea_form.duration.$error.min || idea_form.duration.$error.max">Czas trwania musi być liczbą pomiędzy 1 a 180</small>

        <div class="panel-footer">
            <div class="btn-group">
                <button type="submit" class="btn btn-success" ng-disabled="idea_form.$invalid">Zapisz</button>
                <button ng-click="cancel()" type="button" class="btn btn-danger">Anuluj</button>
            </div>
        </div>
    </div>
</form>
