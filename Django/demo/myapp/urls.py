from django.urls import path
from . import views

urlpatterns = [
    path("", views.home_view, name="Home"),
    path("about/", views.about_view, name="About"),
    path("contact/", views.contact_view, name="Contact"),
    path("todos/", views.todos_view, name="Todos"),
]