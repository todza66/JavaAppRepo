from django.shortcuts import render



def home(request):
    return render(request, 'itreporting/home.html')


def about(request):
     return render(request, 'itreporting/about.html')

def report(request):
    daily_report ={
        'issues': Issue.objects.all()
    }
    return render(request, 'itreporting/report.html', daily_report)

# Create your views here.

