from django.shortcuts import render, HttpResponse
from .models import TodoItem

# Create your views here.
def home_view(request):
    return render(request, "home.html")

def about_view(request):
    return render(request, "about.html")

def contact_view(request):
    return render(request, "contact.html")
    
def todos_view(request):
    items = TodoItem.objects.all()
    return render(request, "todos.html", {"todos": items})

